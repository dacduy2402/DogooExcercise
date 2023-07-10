import '../src/App.css';
import { YoutubeData } from './YoutubeData';

function App() {
  console.log(YoutubeData);
  return (
    <div className="youtube-list">
      {YoutubeData.map((item, index) => {
        return(
          <YoutubeItem 
          id = {item.id} 
          image = {item.image}
          avatar = {item.avatar}
          title = {item.title}
          author = {item.author}
        ></YoutubeItem>
        );
      })}
      {/* <YoutubeItem
        image = "https://images.unsplash.com/photo-1494783367193-149034c05e8f?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8c2NlbmVyeXxlbnwwfHwwfHx8MA%3D%3D&auto=format&fit=crop&w=400&q=60"
        avatar = "https://images.unsplash.com/photo-1568602471122-7832951cc4c5?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8bWFufGVufDB8fDB8fHww&auto=format&fit=crop&w=400&q=60"
        title = "Start with Reactjs"
        author = "Đắc Duy"
      ></YoutubeItem>
      <YoutubeItem
        image = "https://images.unsplash.com/photo-1619441207978-3d326c46e2c9?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1469&q=80"
        avatar = "https://images.unsplash.com/photo-1568602471122-7832951cc4c5?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8bWFufGVufDB8fDB8fHww&auto=format&fit=crop&w=400&q=60"
        title = "Start with Reactjs"
        author = "Đắc Duy"
      ></YoutubeItem>
      <YoutubeItem
        image = "https://images.unsplash.com/reserve/bOvf94dPRxWu0u3QsPjF_tree.jpg?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1476&q=80"
        avatar = "https://images.unsplash.com/photo-1568602471122-7832951cc4c5?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8bWFufGVufDB8fDB8fHww&auto=format&fit=crop&w=400&q=60"
        title = "Start with Reactjs"
        author = "Đắc Duy"
      ></YoutubeItem>
      <YoutubeItem
        image = "https://images.unsplash.com/photo-1454372182658-c712e4c5a1db?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1470&q=80"
        avatar = "https://images.unsplash.com/photo-1568602471122-7832951cc4c5?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8bWFufGVufDB8fDB8fHww&auto=format&fit=crop&w=400&q=60"
        title = "Start with Reactjs"
        author = "Đắc Duy"
      ></YoutubeItem> */}
    </div>
  );
}

function YoutubeItem(props){
  return (
    <div className = "youtube-item">
        <div className='youtube-image'>
          <img src={props.image}></img>
        </div>
        <div className='youtube-footer'>
          <img src={props.avatar} className='youtube-avatar'></img>
          <div className='youtube-info'>
            <h3 className='youtube-title'>{props.title || `This is example of title ${props.id}`}</h3>
            <h4 className='youtube-author'>{props.author || 'This is example of author'}</h4>
          </div>
        </div>
    </div>
  )
}

export default App;
