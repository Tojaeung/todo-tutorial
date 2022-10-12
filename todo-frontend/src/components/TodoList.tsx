import { useState } from 'react';
import { Box, Button, TextField } from '@mui/material';
import Checkbox from '@mui/material/Checkbox';
import List from '@mui/material/List';
import ListItem from '@mui/material/ListItem';
import ListItemButton from '@mui/material/ListItemButton';
import ListItemText from '@mui/material/ListItemText';
import { colors } from '@styles/theme';

function TodoList() {
  const [todo, setTodo] = useState('');
  const [checked, setChecked] = useState([1]);

  const handleToggle = (value: number) => () => {
    const currentIndex = checked.indexOf(value);
    const newChecked = [...checked];

    if (currentIndex === -1) {
      newChecked.push(value);
    } else {
      newChecked.splice(currentIndex, 1);
    }

    setChecked(newChecked);
  };

  return (
    <Box>
      <TextField variant="standard" label="입력" size="medium" onChange={(e) => setTodo(e.target.value)} />
      <Button variant="contained" size="medium" color="secondary">
        추가
      </Button>

      <List sx={{ mt: '20px', bgcolor: colors.body_bg }}>
        {[0, 1, 2, 3].map((value) => {
          return (
            <ListItem
              key={value}
              secondaryAction={
                <Checkbox edge="end" onChange={handleToggle(value)} checked={checked.indexOf(value) !== -1} />
              }
              disablePadding
            >
              <ListItemButton>
                <ListItemText primary={`Line item ${value + 1}`} />
              </ListItemButton>
            </ListItem>
          );
        })}
      </List>
    </Box>
  );
}

export default TodoList;
