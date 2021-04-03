import React, {useEffect, useState} from 'react'
import { Navbar, Nav, Form, FormControl, Button } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
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
   <Navbar bg="dark" variant="dark">
    <Navbar.Brand href="#home">Q&A</Navbar.Brand>
    <Nav className="mr-auto">
      <Nav.Link href="/">Home</Nav.Link>
      <Nav.Link href="/UserRegister">회원가입</Nav.Link>
      <Nav.Link href="/UserLogin">로그인</Nav.Link>
      <Nav.Link href="/UserLogout">로그아웃</Nav.Link>
    </Nav>
    <Form inline>
      <FormControl type="text" placeholder="Search" className="mr-sm-2" />
      <Button variant="outline-info">Search</Button>
    </Form>
 </Navbar>
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
            <div >
                <Link to={`/QnaRegister`}>등록</Link>
            </div>
        </form>

    )

}

export default QnaList;