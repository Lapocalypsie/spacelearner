import Img from "@/components/shared/background";
import "./globals.css";
import { Inter } from "next/font/google";

const inter = Inter({ subsets: ["latin"] });

export const metadata = {
  title: "Space Learning",
  description:
    "Libérez votre potentiel d'apprentissage et obtenez de meilleurs résultats scolaires",
};

export default function RootLayout({ children }: any) {
  return (
    <html lang="fr">
      <body
        className={`${inter.className} bg-gradient-to-r from-violet-500 to-fuchsia-500`}
      >
        {children}
      </body>
    </html>
  );
}
