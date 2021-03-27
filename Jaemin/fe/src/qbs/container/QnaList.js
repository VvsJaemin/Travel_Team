import React from 'react'
import axios from 'axios'


const QnaList =()=>{

    const reg =e=>{
        e.preventDefault() // 비동기 처리
        axios.get('http://localhost:8080/qna/list',
        {

        })
        .then(res => {
            console.log(JSON.stringify(res))
            alert(`게시글이 등록 됐습니다.`)
        })
        .catch(err =>{
            alert(`다시 등록 해주세요: ${err}`)
        } )
    }


return(
    <form>
    <table>
    <thead>
          <tr>
            <th>No</th>
            <th>제목</th>
            <th>작성자</th>
            <th>등록일</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>1</td>
            <td>첫번째 게시글입니다.</td>
            <td>홍길동</td>
            <td>2021-03-27</td>
          </tr>
        </tbody>
    </table>
    </form>
)
}

export default QnaList;