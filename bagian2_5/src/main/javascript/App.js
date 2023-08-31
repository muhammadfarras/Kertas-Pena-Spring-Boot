import React from 'react'

import ListOfVideos from './ListOfVideos'
import NewVideo from './NewVideo'
import { Footer } from './Footer'

export function App(){
    return (
        <div>
            <ListOfVideos/>
            <NewVideo/>
            <Footer/>
        </div>
    )
}