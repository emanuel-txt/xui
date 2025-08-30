import React, { useState, useEffect } from 'react';
import { 
  Container, 
  Typography, 
  Table, 
  TableBody, 
  TableCell, 
  TableHead, 
  TableRow,
  Button,
  Dialog,
  DialogTitle,
  DialogContent,
  TextField
} from '@mui/material';
import axios from 'axios';

const Admin = () => {
  const [produtos, setProdutos] = useState([]);
  const [open, setOpen] = useState(false);
  const [produtoAtual, setProdutoAtual] = useState({});

  const carregarProdutos = async () => {
    const response = await axios.get('http://localhost:64000/api/produtos');
    setProdutos(response.data);
  };

  const salvarProduto = async (produto) => {
    await axios.put(`http://localhost:64000/api/admin/produtos/${produto.id}`, produto);
    carregarProdutos();
    setOpen(false);
  };

  return (
    <Container>
      <Typography variant="h4">Painel Administrativo</Typography>
      <Table>
        <TableHead>
          <TableRow>
            <TableCell>Código</TableCell>
            <TableCell>Nome</TableCell>
            <TableCell>Preço</TableCell>
            <TableCell>Estoque</TableCell>
            <TableCell>Ações</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {produtos.map(produto => (
            <TableRow key={produto.id}>
              <TableCell>{produto.codigo}</TableCell>
              <TableCell>{produto.nome}</TableCell>
              <TableCell>{produto.preco}</TableCell>
              <TableCell>{produto.estoque}</TableCell>
              <TableCell>
                <Button onClick={() => {
                  setProdutoAtual(produto);
                  setOpen(true);
                }}>
                  Editar
                </Button>
              </TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </Container>
  );
};

export default Admin;
