import type { GetServerSideProps, NextPage } from 'next';
import axios from 'axios';
import styled from 'styled-components';
import HeadMeta from '@components/HeadMeta';
import { useAppDispatch, useAppSelector } from '@hooks/redux.hook';
import TodoList from '@features/todos';
import { fetchTodos } from '@features/todos/todos.thunk';
import { TodoType, selectTodos } from '@features/todos/todos.slice';

const Home: NextPage<{ todos: TodoType[] }> = ({ todos }) => {
  return (
    <Container>
      <HeadMeta
        title="todoApp"
        description="나다호다"
        image="http://t1.daumcdn.net/friends/prod/editor/dc8b3d02-a15a-4afa-a88b-989cf2a50476.jpg"
        url="https://www.naver.com"
      />

      <Title>간단한 Todo App</Title>
      <TodoList todos={todos} />
    </Container>
  );
};

export const getServerSideProps: GetServerSideProps = async () => {
  const dispatch = useAppDispatch();
  const todos = useAppSelector(selectTodos);
  try {
    await dispatch(fetchTodos);
  } catch (err: any) {
    alert(err.msg);
  }

  return { props: { todos } };
};

const Container = styled.div`
  margin: 0 1;
  display: flex;
  flex-direction: column;
  align-items: center;
`;
const Title = styled.h1`
  font-size: 30px;
`;

export default Home;
