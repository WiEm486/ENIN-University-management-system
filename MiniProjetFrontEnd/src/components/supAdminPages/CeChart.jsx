import React from 'react'
import "./pie.css"

 const CeChart = () => {
  return (
    <figure className="pie-chart">
     <h2 style={{textAlign:"center",fontWeight:"50"}}>Spécialités</h2> 
    <figcaption>
      Informatique<span style={{ color: '#FFA500' }}></span><br />
     Mécanique<span style={{ color: '#D2E6E4' }}></span><br />
     Génie Civil<span style={{ color: '#fbb3b5' }}></span><br />
    Electrique<span style={{ color: '#0B7077' }}></span><br />
      {/* Renewable 6<span style={{ color: '#59a14f' }}></span><br />
      Other 7<span style={{ color: '#edc949' }}></span> */}
    </figcaption>
   
  </figure>
  )
}

export default CeChart