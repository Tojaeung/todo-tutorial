import axios from 'axios';
import { useState } from 'react';
import styled from 'styled-components';
import { TodoType } from '@interfaces/todo';

interface IProps {
  todos: TodoType[];
}

function TodoList({ todos }: IProps) {
  const [todo, setTodo] = useState('');
  // const [todos, setTodos] = useState<TodoType[]>([]);

  const addTodo = async () => {
    const res = await axios.post(`${process.env.NEXT_PUBLIC_API_URL}/todos`, { name: todo, completed: false });
  };

  return (
    <Container>
      <TodoInputBox>
        <TodoInput onChange={(e) => setTodo(e.target.value)} />
        <AddTodoButton onClick={addTodo}>추가</AddTodoButton>
      </TodoInputBox>
      <ul>
        {todos.map((todo) => (
          <li>{todo.name}</li>
        ))}
      </ul>
    </Container>
  );
}

const Container = styled.div`
  width: 320px;
  display: flex;
  flex-direction: column;
  align-items: center;
`;

const TodoInputBox = styled.div`
  display: flex;
  gap: 10px;
`;
const TodoInput = styled.input`
  padding: 10px 5px;
  font-size: 15px;
  outline: none;
`;
const AddTodoButton = styled.button`
  font-size: 17px;
  border: none;
  border-radius: 5px;
  background-color: ${({ theme }) => theme.palette.green};
  color: white;
  cursor: pointer;
`;

export default TodoList;
