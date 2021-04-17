import React, {useState, useCallback} from 'react'
import {Link} from 'react-router-dom';
import axios from 'axios'

const QnaRegister = (props) => {

    const [register, setRegister] = useState({})
    const {title, content, writer} = register

    const reg = (e) => {
        e.preventDefault()
        axios
            .post('http://localhost:8080/qna', {title, content, writer})
            .then(res => {
                console.log(res)
                alert('게시글 등록이 완료되었습니다.')
                props
                    .history
                    .push('/')
            })
            .catch(() => {
                alert(`빈 곳 없이 작성해주세요`)
            })
        }

    const handleSubmit = useCallback(e => {
        const {name, value} = e.target;
        setRegister({
            ...register,
            [name]: value
        })
    },)

    return (
        <form>
            <table>
                <thead>Q&A를 등록해주세요</thead>
                <tbody>
                    <tr>
                        <th>제목 :
                        </th>
                        <td><input
                            type='text'
                            placeholder='제목을 입력하세요'
                            name='title'
                            value={register.title}
                            onChange={handleSubmit}/></td>
                    </tr>
                    <tr>
                        <th>내용 :</th>
                        <td>
                            <textarea
                                cols="30"
                                rows='10'
                                placeholder='내용을 입력하세요'
                                name='content'
                                value={register.content}
                                onChange={handleSubmit}></textarea>
                        </td>
                    </tr>
                    <tr>
                        <th>작성자 :
                        </th>
                        <td><input type="text" name="writer" value={register.writer} onChange={handleSubmit}/></td>
                    </tr>
                    <tr>
                        <td>
                            <input type='button' onClick={reg} value='등록'/>
                        </td>
                        <td>
                            <Link to="./QnaList">
                                <button>취소</button>
                            </Link>
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
    )
}

export default QnaRegister;