const QnaRegister =()=>{

const register =()=>{
    const reg =e=>{
        e.preventDefault() // 비동기 처리
        alert('작성하신 글을 등록합니다.')
        axios.get('http://localhost:8080/qna/save')
        .then(res => {
            alert('')
        })
    }
}

return(
    <form>
        <div className="container"/>
    </form>
)
}