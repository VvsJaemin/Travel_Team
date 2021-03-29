import React from 'react'
import QnaRegister from './qbs/container/QnaRegister'
import QnaList from './qbs/container/QnaList'
import QnaModify from './qbs/container/QnaModify'
import QnaRead from './qbs/container/QnaRead'
import { Route } from 'react-router-dom'
import Home from './cmm/container/Home'




const App =()=> {
  
  return(<>
    <Route path='/' component={Home} exact/>
    <Route path='/QnaRegister' component={QnaRegister}/>
    <Route path='/QnaList' component={QnaList}/>
    <Route path='/QnaModify' component={QnaModify}/>
    <Route path='/QnaRead/:boardNo' component={QnaRead}/>
 
   

  </>)

  }
 

export default App;
