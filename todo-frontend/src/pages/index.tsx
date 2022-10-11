import type { NextPage } from 'next';
import Head from 'next/head';
import TodoList from '@components/TodoList';
import { Box, Button, TextField } from '@mui/material';

const Home: NextPage = () => {
  return (
    <div>
      <Head>
        <title>토재웅님의 간단한 Todo</title>
      </Head>
      <h1>Todo App</h1>
      <Box sx={{ display: 'flex', gap: '5px' }}>
        <TextField label="할일 작성" variant="outlined" />
        <Button sx={{ color: 'white', fontWeight: '700' }} variant="contained">
          추가
        </Button>
      </Box>
      <TodoList />
    </div>
  );
};

// export const getServerSideProps = async () => {
//   const todos = await axios.get('http://localhost:8080/todos');

//   return {
//     props: { todos },
//   };
// };

export default Home;
