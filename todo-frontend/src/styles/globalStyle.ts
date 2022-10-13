import { createGlobalStyle } from 'styled-components';
import { normalize } from 'styled-normalize';

export const GlobalStyles = createGlobalStyle`
  ${normalize}
  * {
    box-sizing: border-box;
    text-decoration: none;
    font-family: 'Noto Sans KR', sans-serif;
  }
  
  html {
    font-size: 62.5%;
  }

`;
