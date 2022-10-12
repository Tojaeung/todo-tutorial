import HeadMeta from '@components/HeadMeta';
import TodoList from '@components/TodoList';
import { Container, Typography } from '@mui/material';
import type { NextPage } from 'next';

const Home: NextPage = () => {
  return (
    <Container
      maxWidth="sm"
      sx={{
        margin: '0 1',
        display: 'flex',
        flexDirection: 'column',
        alignItems: 'center',
        gap: '10px',
      }}
    >
      <HeadMeta
        title="todoApp"
        description="간단한 투두앱"
        image="http://t1.daumcdn.net/friends/prod/editor/dc8b3d02-a15a-4afa-a88b-989cf2a50476.jpg"
        url="https://www.naver.com"
      />
      <Typography sx={{ p: '40px 0' }} variant="h3">
        간단한 Todo App
      </Typography>
      <TodoList />
    </Container>
  );
};

// export const getServerSideProps = async () => {
//   const todos = await axios.get('http://localhost:8080/todos');

//   return {
//     props: { todos },
//   };
// };

export default Home;
