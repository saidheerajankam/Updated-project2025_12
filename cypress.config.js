const { defineConfig } = require("cypress");

module.exports = defineConfig({
  e2e: {
    supportFile: "cypress/support/e2e.js",

    setupNodeEvents(on, config) {
      on("task", {
        logFilteredRequests(requests) {
          return requests.filter(r => r.url.includes("/api"));
        }
      });
    },

    specPattern: "cypress/e2e/**/*.js"
  }
});