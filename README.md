# SimpleParticleSystem:
A simple particle system in javaFX using canvas.

Showcase:
https://www.youtube.com/watch?v=XEOYcSyBgf0

# Details:
- No frameworks / dependencies are used 
- Runs smooth up to 100 000 particles (i7 6700HQ)
- Right click to create 1000 particles (change amount in DrawScreen class)
- Left click and drag to move Attractor across the screen
- Play around with G (Gravitational Constant) in Particle class for different results 
   
      //higher G = bigger vector length = more acceleration

- Initial velocity (initial moving direction) of the particle gets randomly generated (Particle class):
      
      private final double vel_strength = 10;
      
      //random initial velocity for x and y between 10 and -10
      private void detVel(){
          this.vel = new Vector(Math.random() * vel_strength * 2 - vel_strength, Math.random() * vel_strength * 2 - vel_strength);
      }

- If you don't want initial velocity, make vel_strength = 0 or:
      
      //no initial velocity
      private void detVel(){
          this.vel = new Vector(0,0);
      }
  
- Putting the GameLoop in a differend Thread then the canvas (to maximise performance) creates problems when drawing. Drawing to the canvas needs to be done in the main thread. The simplest way was using: 

      EventHandler<ActionEvent> gameUpdate = event -> {
          center.update();
          center.draw();
      };
        
      gameLoop = new Timeline(new KeyFrame(Duration.millis(33.3), gameUpdate));
      gameLoop.setCycleCount(Animation.INDEFINITE);
      gameLoop.play();

- The following lines of code (DrawScreen) limit the creation of particles to 100 000. When creating more then 100 000 particles the ram and cpu usage increases exponentialy. Removing may cause the program / your pc to freeze.

      if (amount_particles + particles_per_klik <= 100000) {
        amount_particles += particles_per_klik;
        for (int i = 0; i < particles_per_klik; i++) {
          createParticle(e.getX(), e.getY(), attractor);
        }
      }
