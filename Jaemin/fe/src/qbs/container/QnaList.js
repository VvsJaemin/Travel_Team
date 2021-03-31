import React, {useEffect, useState} from 'react'
import axios from 'axios'
import {Link} from 'react-router-dom';
import '../component/QnaList.css'

const QnaList = () => {

    const [List, setList] = useState([]);

    const fetchList = () => {
        axios
            .get('http://localhost:8080/qna/list')
            .then(res => {
                console.log(res)
                setList(res.data)
            })
            .catch((err) => {
                console.log(err)
            });
    };

    useEffect(() => {
        console.log(List)
        fetchList();
    }, [])

    return (
        <form >
            <div>Q&A 게시판
                <table>
                    <thead>
                        <tr>
                            <th>글 번호</th>
                            <th>제목</th>
                            <th>작성자</th>
                            <th>등록일</th>
                            <th>상세읽기</th>
                        </tr>
                    </thead>
                    {
                        List.map(
                            (qna) => [<tbody>
                                <tr key={qna.boardNo}>
                                    <td >{qna.boardNo}</td>
                                    <td>
                                        {qna.title}
                                    </td>
                                    <td>{qna.writer}</td>
                                    <td>{new Date(qna.regDate).toLocaleDateString()}</td>
                                    <td>
                                        <Link to={`QnaRead/${qna.boardNo}`}>
                                            <button>자세히읽기</button>
                                        </Link>
                                    </td>
                                </tr>
                            </tbody>
                                ]
                        )
                    }

                </table>
            </div>
            <div>
                <Link to={`/QnaRegister`}>등록</Link>
            </div>
        </form>

    )

}

export default QnaList;