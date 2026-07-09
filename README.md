```markdown name=README.md
# E-Commerce (Backend + Frontend)

An e‑commerce demo project with a Java (Spring Boot style) backend and a TypeScript/Node frontend. The backend implements core application services (controllers, repositories, services, models) and the frontend provides the UI/assets for the shop.

## Stack
- Languages: Java (backend), TypeScript / JavaScript (frontend), CSS, images
- Backend: Java + Maven (project under Backend/ECom-proj, includes Maven wrapper)
- Frontend: Node/npm-based TypeScript frontend (project under Frontend)
- Notable code locations:
  - Backend/ECom-proj/pom.xml — Maven build file
  - Backend/ECom-proj/mvnw, mvnw.cmd — Maven wrapper
  - Backend/ECom-proj/src/main/java/com/example/ECom_proj — main backend package (EComProjApplication.java)
  - Backend/ECom-proj/src/main/java/com/example/ECom_proj/Controller — HTTP controllers
  - Backend/ECom-proj/src/main/java/com/example/ECom_proj/Service — business logic
  - Backend/ECom-proj/src/main/java/com/example/ECom_proj/Repository — persistence layer
  - Frontend/ — frontend sources and assets (contains .env, package-lock.json, image assets like shoppro.webp)

## Repository layout
```
Backend/
  ECom-proj/
    mvnw, mvnw.cmd
    pom.xml
    src/
      main/
        java/
          com/example/ECom_proj/
            EComProjApplication.java
            Controller/      # HTTP endpoints
            Service/         # business logic
            Repository/      # data access
            model/           # domain models
        resources/          # application.properties / other resources
Frontend/
  .env
  package-lock.json
  shoppro.webp
  ...                   # frontend source files (install with npm)
```

## How to run

Prerequisites:
- Java (check pom.xml for required Java version)
- Node.js and npm (for frontend)

Backend
```bash
# from repo root
cd Backend/ECom-proj

# Unix / macOS
./mvnw clean package
./mvnw spring-boot:run

# Windows (PowerShell / CMD)
mvnw.cmd clean package
mvnw.cmd spring-boot:run

# or run built jar
java -jar target/*.jar
```
Notes:
- Check `Backend/ECom-proj/pom.xml` for exact Java version and any additional startup instructions or profiles.
- See `Backend/ECom-proj/src/main/resources` for configuration (datasource, ports, profiles).

Frontend
```bash
cd Frontend
npm install
# start dev server (check package.json for exact script name)
npm start
# or build for production
npm run build
```
Notes:
- Frontend environment variables are stored in `Frontend/.env`. Confirm variable names used by the app (for example API base URL) in the frontend source (or package.json / config files).
- Ensure the frontend's API base URL points to the running backend.

## Configuration / Environment
Common configuration areas to check and set:
- Backend: application properties (port, datasource URL, username/password), environment-specific profiles (check resources/)
- Frontend: API base URL and any public keys or feature flags in `Frontend/.env`

## API
For exact endpoints, request/response DTOs and example payloads, open:
- Backend/ECom-proj/src/main/java/com/example/ECom_proj/Controller

You can exercise endpoints with curl/Postman once the backend is running; check controller mappings for exact paths.

## Development & Tests
- Backend tests: run `./mvnw test` from Backend/ECom-proj
- Frontend tests/lint: check `Frontend/package.json` for `test`, `lint` scripts

## Contributing
- Open issues to report bugs or request features.
- Create feature branches, include tests for backend changes, and provide a clear PR description.
- Keep API changes backwards compatible or document breaking changes.

## Troubleshooting
- Backend won't start: verify Java version and check application logs for missing configuration or DB connectivity errors.
- Frontend can't reach backend: verify frontend env variable pointing to the backend host/port and CORS configuration on the backend.

## Contact / References
- Backend main app: Backend/ECom-proj/src/main/java/com/example/ECom_proj/EComProjApplication.java
- Controllers: Backend/ECom-proj/src/main/java/com/example/ECom_proj/Controller
- Frontend entry & scripts: see Frontend/ (inspect package.json for exact start/build/test scripts)
```
