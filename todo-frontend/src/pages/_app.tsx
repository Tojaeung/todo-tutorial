import type { AppProps } from 'next/app';
import CssBaseline from '@mui/material/CssBaseline';
import { ThemeProvider } from '@mui/material';
import { theme } from '@styles/theme';
import { Provider } from 'react-redux';
import wrapper from '@store/store';

function MyApp({ Component, ...rest }: AppProps) {
  const { store, props } = wrapper.useWrappedStore(rest);

  return (
    <ThemeProvider theme={theme}>
      <CssBaseline />
      <Provider store={store}>
        <Component {...props.pageProps} />;
      </Provider>
    </ThemeProvider>
  );
}

export default MyApp;
