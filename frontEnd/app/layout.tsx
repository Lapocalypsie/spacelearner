import "./globals.css";
import { Inter } from "next/font/google";

const inter = Inter({ subsets: ["latin"] });

export const metadata = {
  title: "Space Learning",
  description:
    "Libérez votre potentiel d'apprentissage et obtenez de meilleurs résultats scolaire,",
};

export default function RootLayout({ children }: any) {
  return (
    <html lang="fr">
      <body className={inter.className}>{children}</body>
    </html>
  );
}
