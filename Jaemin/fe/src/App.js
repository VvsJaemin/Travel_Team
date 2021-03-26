import React from 'react'
import axios from 'axios'

const App =()=> {
  const test =e=>{
      e.preventDefault()
      alert('테스트')
      axios.get(`http://localhost:8080/qna/list`,
      {
   
      })
        .then(res=>{
          alert(`테스트 성공: ${JSON.stringify(res)}`)
        })
        .catch(err=>{
          alert(`다시 시도 해주세요 : ${err}`)
        })
  }

  return (
    <div><h1>테스트</h1><button onClick={test}>등록</button></div>
  )
 
}

export default App;
