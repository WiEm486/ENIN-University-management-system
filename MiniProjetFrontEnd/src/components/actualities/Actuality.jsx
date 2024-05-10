import React from 'react'
import './Actualities.css'
const Actuality = ({year , month , day , title}) => {
  return (
    <div className="actuality">
        <div className="actualityDate">
            <div className="actualityYear">{year}</div>
            <div className="actualityDay">{day}</div>
            <div className="actualityMonth">{month}</div>
        </div>
        <div className="actualityTitle">{title}</div>
        <button className="actualityConsultButton">Consulter</button>
    </div>
  )
}

export default Actuality