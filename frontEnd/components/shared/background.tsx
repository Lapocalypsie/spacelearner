import Image from "next/image";
import spaceImage from "public/space.jpg";

export default function Img() {
  return (
    <div
      style={{
        position: "relative",
        width: "100%",
        height: "100vh",
        overflow: "hidden",
      }}
    >
      <Image
        src={spaceImage}
        alt="Space Background"
        layout="fill"
        objectFit="cover"
        placeholder="blur"
        priority // Optional: use this if the image is important for the user experience
      />
    </div>
  );
}
    