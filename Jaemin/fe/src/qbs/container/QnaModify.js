import React, {useState} from 'react'
import axios from 'axios'
import { Link } from 'react-router-dom';
const QnaModify = (props) => {
    const [update, setUpdate] = useState({})
    const [ title, setTitle] = useState("")
    const [ content, setContent] = useState("")

    const onChangeTitle=(e)=>{
        setTitle(e.target.value)
    }
    const onChangeContent=(e)=>{
        setContent(e.target.value)
    }
    
    const Modify = e => {
        e.preventDefault()
        axios.put(`http://localhost:8080/qna/modify/${props.match.params.Id}`, { 
            boardNo: props.match.params.Id, 
            title, 
            content })
        .then(res=>{
            console.log(res)
            setUpdate(res.data)
            alert('게시글 수정이 완료되었습니다.')
            props.history.push(`/QnaRead/${props.match.params.Id}`)
        })
        .catch((err)=>{
            console.log(err)
        })
        }

    return (  
    <form>
        <table>
            <thead>게시글 수정</thead>
            <tbody>
                <tr>
                <th>제목 :  </th>
                <td><input type='text' placeholder='제목을 수정하세요' name='title' onChange={onChangeTitle}/></td>
                </tr>
                <tr>
                    <th>내용 :</th>
                    <td><textarea cols="30" rows='10' placeholder='내용을 수정하세요' name='content' onChange={onChangeContent}></textarea></td>
                </tr>
               
                <tr>
                    <td>
                    <input type='button' onClick={Modify} value='수정'/>
                       
                    </td>
                </tr>
            </tbody>
        </table>
        </form>)
}

export default QnaModify;