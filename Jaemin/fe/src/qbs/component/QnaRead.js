import React, {useState, useEffect} from 'react'
import {Link} from 'react-router-dom';
import axios from 'axios'

const QnaRead = (props) => {

    const [detail, setDetail] = useState({})

    const fetchOne = () => {

        axios
            .get(`http://localhost:8080/qna/read/${props.match.params.id}`)
            .then(res => {
                console.log(res)
                setDetail(res.data)
            })
            .catch((err) => {
                console.log(err)
            });
    };

    const deleteOne = () => {
        if (window.confirm('정말 삭제하시겠습니까?')) 
            axios
                .delete(`http://localhost:8080/qna/delete/${props.match.params.id}`)
                .then(res => {
                    console.log(res)
                    alert('등록하신 글이 삭제 되었습니다.')
                    props
                        .history
                        .push('/')
                })
                .catch((err => {
                    console.log(err)
                }))
            }
    
    useEffect(() => {
        fetchOne();

    }, [])

    return (
        <> < div > <table>
            <thead>
                <tr>
                    <th>No</th>
                    <th>제목</th>
                    <th>내용</th>
                    <th>작성자</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>{detail.boardNo}</td>
                    <td>{detail.title}</td>
                    <td>{detail.content}</td>
                    <td >{detail.writer}</td>
                </tr>
            </tbody>
        </table>
        <div>
            <Link to={`/QnaModify/${detail.boardNo}`}>
                <button>수정하기</button>
            </Link>
        </div>
        <button onClick={deleteOne}>삭제하기</button>
        <td>
            <Link to="/">
                <button>나가기</button>
            </Link>
        </td>

    </div>

</>

    )
}

export default QnaRead;