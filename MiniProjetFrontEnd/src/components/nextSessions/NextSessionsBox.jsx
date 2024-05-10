import React from 'react'
import './NextSessions.css'
import Session from './Session'

const NextSessionsBox = () => {
    const sessions = [
        {
            blocNumber: "I",
            roomNumber: "12",
            subjectName: "Math",
            groupName: "ING A2-01",
            beginingSession: "08:00",
            endSession: "10:00"
        },
        {
            blocNumber: "K",
            roomNumber: "16",
            subjectName: "Physique",
            groupName: "ING A2-02",
            beginingSession: "10:00",
            endSession: "12:00"
        },
        {
            blocNumber: "L",
            roomNumber: "13",
            subjectName: "Francais",
            groupName: "ING A2-03",
            beginingSession: "14:00",
            endSession: "16:00"
        }
    ]
  return (
    <div className="actualitiesBox" style={{width : "28vw" , padding :'20px',minWidth :'400px'}}>
        <div className="actualitiesHead" style={{marginBottom : '20px'}}>Les Seances Prochaines</div>
        <div className="actualitiesBody">
          <div className="nextSessionsHeadList">
            <div className="room">Salle</div>
            <div className="subject">Matière</div>
            <div className="time">Temps</div>
          </div>
          {sessions.map((session, index) => {
            return <Session key={index} index={index} {...session} />
          }
          )}
        </div>
        <div className="nextSessionsFooter">Consulter l'emploi du temps</div>   
    </div>
  )
}

export default NextSessionsBox