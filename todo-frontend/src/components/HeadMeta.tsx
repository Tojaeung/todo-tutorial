import Head from 'next/head';

interface IProps {
  title: string;
  description: string;
  url: string;
  image: string;
}

const HeadMeta = ({ title, description, url, image }: IProps) => {
  return (
    <Head>
      <meta name="viewport" content="initial-scale=1.0, width=device-width" />
      <title>{title || '토재웅'}</title>
      <meta name="description" content={description || '토재웅님의 Todo App'} />
      <meta property="og:title" content={title || '토재웅'} />
      <meta property="og:type" content="website" />
      <meta property="og:url" content={url || 'www.naver.com'} />
      <meta property="og:image" content={image} />
      <meta property="og:article:author" content="토재웅" />
    </Head>
  );
};

export default HeadMeta;
