import React, { useState, useEffect } from 'react'
import { Link } from 'react-router-dom';
import axios from 'axios'

const QnaRead=(props)=>{

    const [detail, setDetail] = useState({})

    const fetchOne = ()=>{

        axios.get(`http://localhost:8080/qna/list/{id}`)
        .then(res =>{
            console.log(res)
            setDetail(res.data)
        })
        .catch((err)=>{
            console.log(err)
        });
    };

    useEffect(()=>{
        fetchOne();
    
    }, [])

    return(
        <>
        <div>
            <table>
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
                        <td>{detail.id}</td>
                        <td>{detail.title}</td>
                        <td>{detail.content}</td>
                        <td>{detail.writer}</td>
                    </tr>
                </tbody>
            </table>
            <Link to ='./qna/list'>
                <button>목록으로</button>
                </Link>
            </div>
        </>
    )
}

export default QnaRead;