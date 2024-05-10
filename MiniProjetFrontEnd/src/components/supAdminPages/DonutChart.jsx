import React, { useEffect } from 'react';
import { CircularProgress, Typography } from '@mui/material';

const DonutChart = () => {
    const data = [
      { color: '#D8A9BA', value: 25 },
      { color: '#D2E6E4', value: 40 },
      { color: '#FD661F', value: 35 },
    ];
  
    const radius = 80;
    const circumference = 2 * Math.PI * radius;
  
    let prevAngle = -Math.PI / 2; // Starting angle at the top
  
    return (
      <svg width="200" height="200">
        {data.map((item, index) => {
          const angle = (item.value / 100) * Math.PI * 2;
          const largeArcFlag = angle > Math.PI ? 1 : 0;
          const x1 = 100 + radius * Math.cos(prevAngle);
          const y1 = 100 + radius * Math.sin(prevAngle);
          const x2 = 100 + radius * Math.cos(prevAngle + angle);
          const y2 = 100 + radius * Math.sin(prevAngle + angle);
  
          prevAngle += angle;
  
          return (
            <g key={index}>
              <path
                d={`M ${x1} ${y1} A ${radius} ${radius} 0 ${largeArcFlag} 1 ${x2} ${y2}`}
                fill="none"
                stroke={item.color}
                strokeWidth="20"
              />
            </g>
          );
        })}
      </svg>
    );
  }
export default DonutChart;
