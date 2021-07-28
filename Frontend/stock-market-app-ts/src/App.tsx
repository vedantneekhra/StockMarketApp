import './App.css';
import { FC } from 'react'
import HelloWorld from './components/HelloWorld'
import List from './components/List'
import HomeScreen from './screen/HomeScreen';

const avengers = [
  'Captain America',
  'Iron Man',
  'Black Widow',
  'Thor',
  'Hawkeye',
]

const App: FC = () => {
  return (
    <div className="App">
      <HomeScreen />
    </div>
  );
}

export default App;