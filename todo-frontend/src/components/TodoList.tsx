import * as React from 'react';
import List from '@mui/material/List';
import ListItem from '@mui/material/ListItem';
import ListItemButton from '@mui/material/ListItemButton';
import ListItemText from '@mui/material/ListItemText';
import Checkbox from '@mui/material/Checkbox';

function TodoList() {
  const [checked, setChecked] = React.useState([1]);

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
    <List sx={{ width: '100%', maxWidth: 360, bgcolor: 'background.paper' }}>
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
  );
}

export default TodoList;
