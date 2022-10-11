import type { NextPage } from 'next';
import Head from 'next/head';
import { HomeContainer, Title, InputBox, AddButton } from '@styles/home';
import { TextField } from '@mui/material';
import TodoList from '@components/TodoList';

const Home: NextPage = () => {
  return (
    <>
      <Head>
        <title>토재웅님의 간단한 Todo</title>
      </Head>
      <HomeContainer maxWidth="sm">
        <Title variant="h3">간단한 Todo App</Title>
        <InputBox>
          <TextField variant="standard" label="입력" size="medium" />
          <AddButton variant="contained" size="medium">
            추가
          </AddButton>
        </InputBox>
        <TodoList />
      </HomeContainer>
    </>
  );
};

// export const getServerSideProps = async () => {
//   const todos = await axios.get('http://localhost:8080/todos');

//   return {
//     props: { todos },
//   };
// };

export default Home;
