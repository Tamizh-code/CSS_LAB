# Experiment 09: Exploring N-Stalker - A Vulnerability Assessment Tool

## AIM
To download, install, configure, and explore the features of the **N-Stalker** Web Application Security Scanner to perform vulnerability assessment on a target website.

---

## OVERVIEW OF N-STALKER
N-Stalker Web Application Security Scanner is a vulnerability analysis tool designed to identify web application vulnerabilities (such as Cross-Site Scripting (XSS), SQL Injection, Parameter Tampering, and Information Leakage). It includes a database of over 35,000 web attack signatures.

---

## STEP-BY-STEP PROCEDURE

### Step 1: Download & Install N-Stalker
1. Download N-Stalker Free Edition from the official website ([nstalker.com](https://www.nstalker.com)).
2. Run the installer `.exe` on a Windows environment and complete the setup wizard.

---

### Step 2: Update Vulnerability Signature Database
1. Launch N-Stalker from:
   `Start -> Programs -> N-Stalker -> N-Stalker Free Edition`
2. Click on the **License Manager** tab in the main toolbar.
3. Click the **Update** button to fetch the latest vulnerability definitions.
4. Verify that the update status displays **Up to date**.

---

### Step 3: Configure Scan Session & Target URL
1. Click on the **Scan Session** tab.
2. In the **Target Web Application URL** input box, enter the target website URL (e.g., `http://www.example.com` or a local vulnerable web app URL).

---

### Step 4: Select Scan Policy
Choose one of the four scan policies based on your objective:
- **Manual Test**: Crawls the site and waits for manual vulnerability testing.
- **Full XSS Assessment**: Focuses on identifying Cross-Site Scripting (XSS) vulnerabilities.
- **OWASP Policy**: Tests against the OWASP Top 10 web application vulnerabilities.
- **Web Server Infrastructure Analysis**: Scans web server configurations, headers, and server software vulnerabilities.

---

### Step 5: Optimize Crawl & Scan Settings
1. Click **Optimize Settings** in the setup wizard.
2. Configure crawler parameters:
   - Set maximum pages to crawl (e.g., 40 pages).
   - Set maximum search depth (e.g., depth 5).
   - Set script parsing options and allowed domains/hosts.

---

### Step 6: Start Vulnerability Scanning
1. Click **Start Scan Session**.
2. N-Stalker will crawl the web application, inspect scripts, form fields, parameters, hidden inputs, and HTTP headers.
3. Monitor progress in real-time under the **Scan Session Progress** panel.

---

### Step 7: Generate & Analyze Vulnerability Report
1. Once scanning completes, N-Stalker Report Manager will prompt for report generation.
2. Select **Generate HTML** as the output format.
3. Open and review the generated HTML report.

---

## REPORT VERIFICATION & FINDINGS
The report categorizes security issues with details such as:
- **Severity Level**: High, Medium, Low, or Informational.
- **Vulnerability Class**: (e.g., Cross-Site Scripting, Header Disclosure, Broken Links).
- **Vulnerable URL**: The specific path/parameter affected.
- **Fix / Remediation**: Suggested code or configuration fixes.

---

## RESULT
The N-Stalker Vulnerability Assessment tool was successfully downloaded, installed, and executed to analyze web application security vulnerabilities.
