import { Button } from "@/components/ui/button";
import {
  Dialog,
  DialogContent,
  DialogDescription,
  DialogFooter,
  DialogHeader,
  DialogTitle,
  DialogTrigger,
} from "@/components/ui/dialog";
import { Input } from "@/components/ui/input";
import { Label } from "@/components/ui/label";
import { Textarea } from "../ui/textarea";
import { useState } from "react";
import axios from "axios";

export function Dialogue({
  buttonTitle,
  title,
  description,
  label1,
  label2,
}: any) {
  const [formData, setFormData] = useState({
    titre: "Nouvelle tâche",
    content: "Entrez votre nouvelle tâche ici",
  });

  const handleInputChange = (
    event: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>
  ) => {
    const { name, value } = event.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleFormSubmit = async () => {
    try {
      const formattedData = {
        titleList: formData.titre,
        content: formData.content,
        isDone: false,
      };

      console.log("formattedData", formattedData);

      const response = await axios.post(
        "http://localhost:8080/api/v1/tasks",
        formattedData,
        {
          headers: {
            "Content-Type": "application/json",
          },
        }
      );

      if (response.status === 201) {
        alert("Tache bien ajoutée, vous pouvez quitter la fenêtre");
        // You can add further logic or update your state as needed
      } else {
        console.error(
          "Error saving task:",
          response.status,
          response.statusText
        );
      }
    } catch (error) {
      //@ts-ignore
      console.error("Error making API call:", error.message);
    }
  };

  return (
    <Dialog>
      <DialogTrigger asChild>
        <Button variant="outline">{buttonTitle}</Button>
      </DialogTrigger>
      <DialogContent className="sm:max-w-[425px]">
        <DialogHeader>
          <DialogTitle>{title}</DialogTitle>
          <DialogDescription>{description}</DialogDescription>
        </DialogHeader>
        <div className="grid gap-4 py-4">
          <div className="grid grid-cols-4 items-center gap-4">
            <Label htmlFor="titre" className="text-right">
              {label1}
            </Label>
            <Input
              id="titre"
              name="titre"
              value={formData.titre}
              className="col-span-3"
              onChange={handleInputChange}
            />
          </div>
          <div className="grid grid-cols-4 items-center gap-4">
            <Label htmlFor="content" className="text-right">
              {label2}
            </Label>
            <Textarea
              id="content"
              name="content"
              value={formData.content}
              className="col-span-3"
              onChange={handleInputChange}
            />
          </div>
        </div>
        <DialogFooter>
          <Button type="submit" onClick={handleFormSubmit}>
            Enregistrer
          </Button>
        </DialogFooter>
      </DialogContent>
    </Dialog>
  );
}
