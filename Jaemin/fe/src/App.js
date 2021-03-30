import React from 'react'
import QnaRegister from './qbs/container/QnaRegister'
import QnaList from './qbs/container/QnaList'
import QnaModify from './qbs/container/QnaModify'
import QnaRead from './qbs/container/QnaRead'
import { Route } from 'react-router-dom'
import Home from './cmm/container/Home'




const App =()=> {
  
  return(<>
    <Route path='/' component={QnaList} exact/>
    <Route path='/QnaRegister' component={QnaRegister}/>
    <Route path='/QnaList' component={QnaList}/>
    <Route path='/QnaModify/:Id' component={QnaModify}/>
    <Route path='/QnaRead/:id' component={QnaRead}/>
    
 
   

  </>)

  }
 

export default App;
