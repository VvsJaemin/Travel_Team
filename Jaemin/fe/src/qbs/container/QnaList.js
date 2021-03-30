import React, {useEffect, useState} from 'react'
import axios from 'axios'
import { Link } from 'react-router-dom';
import '../component/QnaList.css'

const QnaList =(prop)=>{

        const [ List, setList ] = useState([]);
   

        const fetchList = () =>{
          axios.get('http://localhost:8080/qna/list')
          .then(res =>{
            console.log(res)
            setList(res.data)
          })
          .catch((err)=>{
            console.log(err)
          });
        };

    useEffect(()=>{
      console.log('rendering')
      fetchList();
    }, [])



  return(
    <form >
    <div>Q&A 게시판
    <table>
    <thead>
          <tr>
            <th>글 번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>등록일</th>
          </tr>
        </thead>
        {List.map((qna)=> [
          <tbody>
          <tr key={qna.boardNo}>
            <td >{qna.boardNo}</td>
            <td><Link to={`QnaRead/${qna.boardNo}`}>{qna.title}</Link></td>
            <td>{qna.writer}</td>
            <td>{new Date(qna.regDate).toLocaleString()}</td>
          </tr>
        </tbody>
        ])}
      
    </table>
    </div>
    <div><Link to={`/QnaRegister`}>등록</Link></div>
    </form>
    
)

}



export default QnaList;