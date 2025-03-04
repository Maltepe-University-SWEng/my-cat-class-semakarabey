
package tr.edu.maltepe.oop;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

class Cat {
    private String name;
    int age;


    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public void meow() {
        System.out.println(name + " says: Meow! 😺");
        playSound("C:\\Users\\Lenovo\\IdeaProjects\\my-cat-class-semakarabey\\module1\\src\\tr\\edu\\maltepe\\oop\\cat_meowing_1_ZAj_Dgz.wav");
    }


    private void playSound(String soundFile) {
        try {
            File file = new File(soundFile);
            if (!file.exists()) {
                System.out.println("Hata: Ses dosyası bulunamadı! Lütfen 'cat_meow.wav' dosyasını proje klasörüne ekleyin.");
                return;
            }

            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();


            Thread.sleep(clip.getMicrosecondLength() / 1000);


            clip.close();
            audioStream.close();
        } catch (UnsupportedAudioFileException e) {
            System.out.println("Hata: Desteklenmeyen ses formatı! Lütfen '.wav' formatında bir dosya kullanın.");
        } catch (IOException e) {
            System.out.println("Hata: Ses dosyası okunurken bir hata oluştu.");
        } catch (LineUnavailableException e) {
            System.out.println("Hata: Ses oynatılamadı! Cihazınız desteklemiyor olabilir.");
        } catch (InterruptedException e) {
            System.out.println("Hata: Thread beklerken kesildi.");
        }
    }
   }







