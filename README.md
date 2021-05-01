# Concurrent Client-Server Model
As part of our Systems Software module at NTU we were tasked with the creation of a concurrent client-server model as a solution for a problem scenario. We implemented this solution using Java and NetBeans. 

### The Scenario:
A farmer wishes to improve the management of his business through the use of technology. He hires your team to devise a distributed system on a TCP/IP-based network infrastructure composed of the following components, all connected to the network:
- A number of digital weather stations controlled by microcomputers
- A connected weather stations (e.g. temperature, barometric pressure, relative humidity, wind force, etc.) at the user’s request through a GUI;
- A central server machine that provides (also via a GUI):
  - Services for new weather stations to connect automatically on powerup and upload its data;
  - Services for new workstations to connect on log in (regulated by a user database), and, after successful connection, obtain an up-to-date description of the field and a list of connected weather stations, and download their respective data on request.

### Running the project:
You should first clone the repository:
`git clone https://github.com/Hannah-Ashna/Systems-Software.git`

Our project makes use of an external library to draw our charts. Hence, you'll need to setup [XCharts](https://knowm.org/open-source/XChart/) using the [jar](https://github.com/Hannah-Ashna/Systems-Software/tree/main/xchart) file available in this repository.  
Once everything is setup within your IDE (We've used NetBeans), you'll need to run Server.java followed by as many instances of the WeatherStations.java and User.java.


