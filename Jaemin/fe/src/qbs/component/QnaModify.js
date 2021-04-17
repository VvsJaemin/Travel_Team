import React, {useState, useEffect, useCallback} from 'react'
import axios from 'axios'
import {Link} from 'react-router-dom';
const QnaModify = (props) => {
    const [update, setUpdate] = useState({})
    const {title, content, writer} = update;


    const Modify = e => {
        e.preventDefault()
        axios
            .put(`http://localhost:8080/qna/modify/${props.match.params.Id}`, {
                boardNo: props.match.params.Id,
                title,
                content,
                writer
             
            })
            .then(res => {
                console.log(res)
                setUpdate(res.data)
                alert('게시글 수정이 완료되었습니다.')
                props
                    .history
                    .push(`/QnaRead/${props.match.params.Id}`)
            })
            .catch((err) => {
                console.log(err)
            })
        }

        const fetchOne = () => {

            axios
                .get(`http://localhost:8080/qna/read/${props.match.params.Id}`)
                .then(res => {
                    console.log(res)
                    setUpdate(res.data)
                })
                .catch((err) => {
                    console.log(err)
                });
        };

        useEffect(()=>{
            fetchOne()
        }, [])

        const handleChange = useCallback( e => {
            const {name, value} = e.target;
            setUpdate({...update, 
                [name] : value});
           
        },[update]);

    return (
        <form>
            <table>
                <thead>게시글 수정</thead>
                <tbody>
                    <tr>
                        <th>제목 :
                        </th>
                        <td><input
                            type='text'
                
                            name='title'
                            value={update.title}
                            onChange={handleChange}/></td>
                    </tr>
                    <tr>
                        <th>내용 :</th>
                        <td>
                            <textarea
                                cols="30"
                                rows='10'
                                placeholder='내용을 수정하세요'
                                name='content' value={update.content}
                                onChange={handleChange}></textarea>
                        </td>
                    </tr>
                    <tr>
                        <th>작성자 :</th>
                        <td>
                            <input name='writer' value={update.writer} onChange={handleChange}readOnly></input>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type='button' onClick={Modify} value='수정'/>

                        </td>
                    </tr>
                    <Link to={`/QnaRead/${props.match.params.Id}`}>
                        <button>나가기</button>
                    </Link>
                </tbody>
            </table>
        </form>
    )
}

export default QnaModify;