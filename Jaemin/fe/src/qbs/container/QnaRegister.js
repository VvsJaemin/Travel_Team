import React, { useState } from 'react'
import axios from 'axios'

const QnaRegister =()=>{
   const [title, setTitle] = useState("")
   const [content, setContent] = useState("")
   const [writer, setWriter] = useState("")
  
const onChangeTitle=(e)=>{
    setTitle(e.target.value)
}

const onChangeContent=(e)=>{
    setContent(e.target.value)
}

const onChangeWriter=(e)=>{
    setWriter(e.target.value)
}


    const reg =(e)=>{
        e.preventDefault()
        axios.post('http://localhost:8080/qna/reg',{
        
        title, 
        content,
        writer  

        })
        .then(res => {
            alert(`테스트 성공: ${JSON.stringify(res)}`)
        })
        .catch(err =>{
            alert(`다시 등록 해주세요: ${err}`)
        } )  
    }




return(
    <form>
    <table>
        <thead>Q&A를 등록해주세요</thead>
        <tbody>
            <tr>
            <th>제목 :  </th>
            <td><input type='text' placeholder='제목을 입력하세요' name='title' onChange={onChangeTitle}/></td>
            </tr>
            <tr>
                <th>내용 :</th>
                <td><textarea cols="30" rows='10' placeholder='내용을 입력하세요' name='content' onChange={onChangeContent}></textarea></td>
            </tr>
            <tr>
                <th>글쓴이 : </th>
                <td><input type="text" name="writer" onChange={onChangeWriter}/></td>
            </tr>
            <tr>
                <td>
                    <input type='button' onClick={reg} value='등록'/>
                   
                </td>
            </tr>
        </tbody>
    </table>
    </form>
)
}

export default QnaRegister;