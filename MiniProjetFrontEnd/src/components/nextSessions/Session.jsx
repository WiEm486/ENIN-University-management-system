import React from 'react'

const Session = ({index,blocNumber,roomNumber,subjectName,groupName,beginingSession,endSession}) => {
  return (
    <div className={`nextSessionsItemList ${ index === 0 && 'nextSession'}`}>
      <div className="room">
        <div className="blocNumber">{`Bloc ${blocNumber}`}</div>
        <div className="roomNumber">{roomNumber}</div>
      </div>
      <div className="subject">
        { index === 0 &&<img src="./assets/nextSession.png" alt="" />}
        <div>
          <div className="subjectName">{`Cours ${subjectName}`}</div>
          <div className="groupName">{`Classe ${groupName}`}</div>
        </div>
      </div>
      <div className="time"><div className="timeBox">{`${beginingSession} - ${endSession}`}</div></div>
    </div>
  )
}

export default Session