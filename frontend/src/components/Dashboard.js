import React from 'react';
import { Grid, Card, Typography } from '@mui/material';

const Dashboard = () => {
  const [dashboardData, setDashboardData] = useState({});

  useEffect(() => {
    const fetchData = async () => {
      const response = await axios.get('/api/dashboard');
      setDashboardData(response.data);
    };
    fetchData();
  }, []);

  return (
    <Grid container spacing={3}>
      <Grid item xs={12} md={6}>
        <Card>
          <Typography variant="h6">Vendas do Dia</Typography>
          <Typography variant="h4">{dashboardData.vendasHoje}</Typography>
        </Card>
      </Grid>
      {/* Mais cards de métricas */}
    </Grid>
  );
};

export default Dashboard;
