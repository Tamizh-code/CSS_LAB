# Experiment 08: Demonstration of Intrusion Detection System (IDS) using Snort

## AIM
To demonstrate an Intrusion Detection System (IDS) using the open-source **Snort** security tool.

---

## PREREQUISITES & SOFTWARE REQUIREMENTS
1. **Snort IDS**: Download installer from [snort.org](https://www.snort.org/downloads).
2. **WinPcap / Npcap**: Required for packet capture on Windows ([winpcap.org](https://www.winpcap.org/install/)).
3. **Snort Rules**: Download rules package (`snortrules-snapshot-xxx.tar.gz`) from Snort website.
4. **WinRAR / 7-Zip**: To extract `.tar.gz` rules files.

---

## STEP-BY-STEP PROCEDURE

### Step 1: Installation & Setup
1. Run the Snort `.exe` installer. Install Snort into `C:\Snort`.
2. Extract the downloaded Snort Rules package using WinRAR/7-Zip.
3. Copy all files from the extracted `rules` folder and paste them into `C:\Snort\rules`.
4. Copy `snort.conf` from the extracted `etc` folder and paste it into `C:\Snort\etc` (overwrite if prompted).

---

### Step 2: Identify Network Interface
1. Open Command Prompt (`cmd.exe`) as Administrator.
2. Navigate to the Snort bin directory:
   ```cmd
   cd C:\Snort\bin
   ```
3. List available network interfaces to find your interface Index number:
   ```cmd
   snort -W
   ```
4. Look for your physical/active network adapter in the output list (e.g., Index `3`).

---

### Step 3: Test Snort in Packet Sniffer Mode
Run Snort in sniffer mode to verify packet capture working on your interface (replace `3` with your interface index):
```cmd
snort -dev -i 3
```
*Press `Ctrl + C` to stop sniffer mode.*

---

### Step 4: Configure `snort.conf` for IDS Mode
Open `C:\Snort\etc\snort.conf` in a text editor (Notepad or Notepad++) and update the following settings:

1. **Set Protected Home Network IP**:
   ```text
   var HOME_NET 192.168.1.0/24
   ```
2. **Set Rules Path**:
   ```text
   var RULE_PATH c:\snort\rules
   ```
3. **Set Library & Dynamic Engine Paths**:
   ```text
   dynamicengine C:\Snort\lib\snort_dynamicengine\sf_engine.dll
   ```
   *(Ensure all library paths use `C:\Snort\lib` instead of Unix paths `/usr/local/lib`)*
4. **Include Configuration & Rule Files**:
   ```text
   include c:\snort\etc\classification.config
   include c:\snort\etc\reference.config
   include $RULE_PATH/icmp.rules
   include $RULE_PATH/icmp-info.rules
   ```
5. **Set Alert Output Log File**:
   ```text
   output alert_fast: snort-alerts.ids
   ```
6. **Disable Incompatible Preprocessors (if errors occur)**:
   Comment out (add `#` at start of line) the following preprocessors if needed:
   ```text
   #preprocessor normalize_ip4
   #preprocessor normalize_tcp: ips ecn stream
   #preprocessor normalize_icmp4
   #preprocessor normalize_ip6
   #preprocessor normalize_icmp6
   ```
7. Save and close `snort.conf`.

---

### Step 5: Execute Snort in IDS Mode
Run Snort in Intrusion Detection System mode using the following command:

#### Option A: Normal Log Mode
```cmd
snort -c c:\snort\etc\snort.conf -l c:\snort\log -i 3
```

#### Option B: Real-Time Console Display (ASCII Mode)
```cmd
snort -A console -i3 -c c:\Snort\etc\snort.conf -l c:\Snort\log -K ascii
```

---

### Step 6: Verify Intrusion Alerts
1. Open another terminal or use a secondary machine on the network.
2. Send ping packets or run an Nmap scan targeting the machine running Snort:
   ```cmd
   ping 192.168.1.50
   ```
   or
   ```cmd
   nmap -sS 192.168.1.50
   ```
3. Observe real-time intrusion alert output on the Snort console.
4. Check generated alert logs in `C:\Snort\log\snort-alerts.ids` or generated IP folders.

---

## RESULT
The Intrusion Detection System (IDS) using Snort software tool was successfully configured, executed, and verified.
