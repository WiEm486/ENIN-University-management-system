import React, { useState, useEffect } from 'react';

const Typewriter = ({ text }) => {
  const [displayText, setDisplayText] = useState('');
  const [index, setIndex] = useState(0);
  const [cursorPosition, setCursorPosition] = useState('0%');

  useEffect(() => {
    let cursorVisible = true;
    const interval = setInterval(() => {
      if (index < text.length) {
        setDisplayText((prevText) => prevText + text[index]);
        setIndex((prevIndex) => prevIndex + 1);
        cursorVisible = !cursorVisible;
        setCursorPosition(cursorVisible ? '0%' : '100%');
      } else {
        clearInterval(interval); // Arrêter l'intervalle lorsque le texte est entièrement écrit
      }
    }, 300); // Réglage de la vitesse de frappe

    return () => clearInterval(interval);
  }, [index, text]);

  return (
    <div style={{ fontSize: '5vh', fontFamily: 'var(--big-font)', color: 'var(--primary-color)', position: 'relative' }}>
      <span style={{ position: 'absolute', left: cursorPosition }}>|</span>
      {displayText}
    </div>
  );
};

export default Typewriter;
