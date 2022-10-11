import styled from '@emotion/styled';
import { Box, Typography, Container, Button } from '@mui/material';
import { colors } from '../theme';

export const HomeContainer = styled(Container)(() => ({
  display: 'flex',
  flexDirection: 'column',
  height: '100vh',
  alignItems: 'center',
  gap: '10px',
  background: colors.body_bg,
}));

export const Title = styled(Typography)(() => ({
  color: colors.primary,
}));

export const InputBox = styled(Box)(() => ({
  display: 'flex',
  justifyContent: 'center',
  alignItems: 'center',
  gap: '10px',
}));

export const AddButton = styled(Button)(() => ({
  backgroundColor: colors.secondary,
  color: colors.white,
}));
