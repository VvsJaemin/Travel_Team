import React from 'react'
import axios from 'axios'
const QnaModify = (props) => {

    const update = e => {
        e.preventDefault() // 비동기 처리
        axios
            .put(`http://localhost:8080/qna/${props.match.params.id = 1}`, {
                "boardNo": 1,
                "title": "sd",
                "content": "ASd",
                "writer": "asd"

            })
            .then(res => {
                alert(`테스트 성공: ${JSON.stringify(res)}`)
            })
            .catch(err => {
                alert(`다시 등록 해주세요: ${err}`)
            })
        }

    return (<input type='button' onClick={update} value='수정'/>)
}

export default QnaModify;