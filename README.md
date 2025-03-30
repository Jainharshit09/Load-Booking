  # Load Booking Service

This project is a Spring Boot application for managing load bookings. It provides RESTful APIs to create, read, update, and delete loads and bookings.

## Technologies Used

- Java
- Spring Boot
- Maven
- Lombok
- JPA (Jakarta Persistence API)
- H2 Database (for development and testing)

## Project Structure

- `com.loadBooking.Load.Booking.Controller`: Contains the REST controllers for handling HTTP requests.
- `com.loadBooking.Load.Booking.Entity`: Contains the entity classes representing the database tables.
- `com.loadBooking.Load.Booking.Repository`: Contains the repository interfaces for data access.
- `com.loadBooking.Load.Booking.Service`: Contains the service classes implementing the business logic.

## Endpoints

### Load Endpoints

- **Create Load**
  - **URL**: `/load/createLoad`
  - **Method**: POST
  - **Request Body**: `Load` object
  - **Response**: Created `Load` object

- **Get All Loads**
  - **URL**: `/load/getAllLoad`
  - **Method**: GET
  - **Response**: List of `Load` objects

- **Get Load by ID**
  - **URL**: `/load/{loadId}`
  - **Method**: GET
  - **Path Variable**: `loadId` (UUID)
  - **Response**: `Load` object

- **Update Load**
  - **URL**: `/load/{loadId}`
  - **Method**: PUT
  - **Path Variable**: `loadId` (UUID)
  - **Request Body**: Updated `Load` object
  - **Response**: Updated `Load` object

- **Delete Load**
  - **URL**: `/load/{loadId}`
  - **Method**: DELETE
  - **Path Variable**: `loadId` (UUID)

### Booking Endpoints

- **Create Booking**
  - **URL**: `/booking/createBooking`
  - **Method**: POST
  - **Request Body**: `Booking` object
  - **Response**: Created `Booking` object

- **Get All Bookings**
  - **URL**: `/booking/getAllBooking`
  - **Method**: GET
  - **Response**: List of `Booking` objects

- **Get Booking by ID**
  - **URL**: `/booking/{bookingId}`
  - **Method**: GET
  - **Path Variable**: `bookingId` (UUID)
  - **Response**: `Booking` object

- **Update Booking**
  - **URL**: `/booking/{bookingId}`
  - **Method**: PUT
  - **Path Variable**: `bookingId` (UUID)
  - **Request Body**: Updated `Booking` object
  - **Response**: Updated `Booking` object

- **Delete Booking**
  - **URL**: `/booking/{id}`
  - **Method**: DELETE
  - **Path Variable**: `id` (UUID)
  - **Response**: Success message

## Running the Application

1. Clone the repository.
2. Navigate to the project directory.
3. Run `mvn spring-boot:run` to start the application.
4. Access the application at `http://localhost:8080`.

## Database Configuration

The application uses an H2 in-memory database for development and testing. The database schema is automatically created based on the JPA entities.

## Error Handling

The application uses `ResponseStatusException` to handle various error scenarios, such as invalid input data or resource not found.

## License

This project is licensed under the MIT License. See the `LICENSE` file for details.
