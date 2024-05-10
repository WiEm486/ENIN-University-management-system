import React from 'react';
import { BarChart, Bar, XAxis, YAxis, CartesianGrid, Tooltip, Legend, ResponsiveContainer } from 'recharts';


const data = [
  { name: 'Dec', Gc: 120, Info: 100, amt: 100 },
  { name: 'Jan', Gc: 100, Info: 80, amt: 2210 },
  { name: 'Feb', Gc: 130, Info: 90, amt: 2290 },
  { name: 'Mar', Gc: 50, Info: 120, amt: 2000 },
  { name: 'Ap', Gc: 80, Info: 50, amt: 2181 },
  { name: 'Mai', Gc: 90, Info: 60, amt: 2500 },
  { name: 'Juin', Gc: 100, Info: 70, amt: 2100 },
];

const ChartD = () => {
  return (
   
    <ResponsiveContainer width="100%" height={350} style={{backgroundColor:"  rgb(249, 245, 245) ",borderRadius:"5%"}}>
     <h2 style={{fontWeight:"50"}}>Présence des Etudiants </h2>
      <BarChart
        data={data}
        margin={{ top: 20, right: 30, left: 20, bottom: 5 }}
      >
        <CartesianGrid strokeDasharray="3 3" />
        <XAxis dataKey="name" />
        <YAxis />
        <Tooltip />
        <Legend />
        <Bar dataKey="Info" stackId="a" fill="var(--third-color)" barSize={20} />
        <Bar dataKey="Gc" stackId="a" fill="var(--secondary-color)" barSize={20} />
      </BarChart>
    </ResponsiveContainer>
  );
};

export default ChartD;
