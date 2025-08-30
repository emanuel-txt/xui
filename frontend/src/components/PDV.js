import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { 
  Container, 
  Paper, 
  Button, 
  Typography, 
  Grid,
  Card,
  CardContent,
  Box,
  Select,
  MenuItem
} from '@mui/material';

const PDV = () => {
  const [produtos, setProdutos] = useState([]);
  const [carrinho, setCarrinho] = useState([]);
  const [formaPagamento, setFormaPagamento] = useState('');
  
  useEffect(() => {
    carregarProdutos();
  }, []);
  
  const carregarProdutos = async () => {
    try {
      const response = await axios.get('/api/produtos', {
        baseURL: 'http://localhost:8080'
      });
      setProdutos(response.data);
    } catch (error) {
      console.error('Erro ao carregar produtos:', error);
      // Adicionar tratamento de erro adequado aqui
    }
  };
  
  const adicionarAoCarrinho = (produto) => {
    setCarrinho([...carrinho, produto]);
  };
  
  const finalizarVenda = async () => {
    const venda = {
      itens: carrinho,
      valorTotal: carrinho.reduce((total, item) => total + item.preco, 0),
      pagamento: {
        formaPagamento,
        valor: carrinho.reduce((total, item) => total + item.preco, 0),
        dataPagamento: new Date()
      }
    };
    
    await axios.post('http://localhost:64000/api/vendas', venda);
    setCarrinho([]);
  };

  return (
    <Container>
      <Typography variant="h4" component="h1" gutterBottom>
        PDV Web
      </Typography>
      <Grid container spacing={2}>
        <Grid item xs={8}>
          <Paper elevation={3}>
            <Box p={2}>
              <Typography variant="h6">Produtos Disponíveis</Typography>
              {produtos.map(produto => (
                <Card key={produto.id} sx={{ mb: 1 }}>
                  <CardContent>
                    <Grid container alignItems="center" justifyContent="space-between">
                      <Grid item>
                        <Typography>{produto.nome}</Typography>
                        <Typography color="textSecondary">
                          R$ {produto.preco}
                        </Typography>
                      </Grid>
                      <Grid item>
                        <Button 
                          variant="contained" 
                          color="primary"
                          onClick={() => adicionarAoCarrinho(produto)}
                        >
                          Adicionar
                        </Button>
                      </Grid>
                    </Grid>
                  </CardContent>
                </Card>
              ))}
            </Box>
          </Paper>
        </Grid>
        <Grid item xs={4}>
          <Paper elevation={3}>
            <Box p={2}>
              <Typography variant="h6">Carrinho</Typography>
              {carrinho.map((item, index) => (
                <Card key={index} sx={{ mb: 1 }}>
                  <CardContent>
                    <Typography>{item.nome}</Typography>
                    <Typography color="textSecondary">
                      R$ {item.preco}
                    </Typography>
                  </CardContent>
                </Card>
              ))}
              <Typography variant="h6" sx={{ mt: 2 }}>
                Total: R$ {carrinho.reduce((total, item) => total + item.preco, 0)}
              </Typography>
            </Box>
          </Paper>
          <Paper sx={{ mt: 2, p: 2 }}>
            <Typography variant="h6">Pagamento</Typography>
            <Select
              value={formaPagamento}
              onChange={(e) => setFormaPagamento(e.target.value)}
              fullWidth
              sx={{ mb: 2 }}
            >
              <MenuItem value="DINHEIRO">Dinheiro</MenuItem>
              <MenuItem value="CARTAO_CREDITO">Cartão de Crédito</MenuItem>
              <MenuItem value="CARTAO_DEBITO">Cartão de Débito</MenuItem>
              <MenuItem value="PIX">PIX</MenuItem>
            </Select>
            <Button 
              variant="contained" 
              color="primary" 
              onClick={finalizarVenda}
              disabled={carrinho.length === 0}
              fullWidth
            >
              Finalizar Venda
            </Button>
          </Paper>
        </Grid>
      </Grid>
    </Container>
  );
};

export default PDV;
