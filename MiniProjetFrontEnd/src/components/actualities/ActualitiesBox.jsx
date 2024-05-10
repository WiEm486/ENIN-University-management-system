import React, { useState } from 'react'
import Actuality from './Actuality'
import './Actualities.css'
const ActualitiesBox = () => {
    const [maxActualities , setMaxActualities] = useState(4)

    const displayAllActualities = () => {
        setMaxActualities(actualities.length)
    }
    const hideAllActualities = () => {
        setMaxActualities(4)
    }

    const actualities = [
        {
            year : '2021',
            month : 'Jan',
            day : '02',
            title : 'Avis aux élèves ingénieurs: Dépôt et soutenances de stages d’été'
        },
        {
            year : '2021',
            month : 'Jan',
            day : '01',
            title : 'Avis aux élèves ingénieurs: Dépôt et soutenances de stages d’été'
        },
        {
            year : '2021',
            month : 'Jan',
            day : '01',
            title : 'Avis aux élèves ingénieurs: Dépôt et soutenances de stages d’été'
        },
        {
            year : '2021',
            month : 'Jan',
            day : '01',
            title : 'Avis aux élèves ingénieurs: Dépôt et soutenances de stages d’été'
        },
        {
            year : '2021',
            month : 'Jan',
            day : '01',
            title : 'Avis aux élèves ingénieurs: Dépôt et soutenances de stages d’été'
        }
    ]
  return (
    <div className="actualitiesBox">
        <div className="actualitiesHead">Actualités</div>
        <div className="actualitiesBody">
            {actualities.slice(0,maxActualities).map((actuality,index) => {
                return (
                    <Actuality key={index} {...actuality} />
                )
            })}
        </div>
        {
            maxActualities === 4 ? <div className="actualitiesFooter" onClick={displayAllActualities}>Voir tout les actualités...</div> 
            : actualities.length > 4 && <div className="actualitiesFooter" onClick={hideAllActualities}>Voir moins --</div>
        }    
    </div>
  )
}

export default ActualitiesBox