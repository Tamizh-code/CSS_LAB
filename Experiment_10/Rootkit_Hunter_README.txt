Experiment 10(b): Defeating Malware - Rootkit Hunter (GMER / rkhunter)

For complete details on both 10(a) Trojan & 10(b) Rootkit Hunter, see README.md in this directory.

Quick Summary for GMER (Windows):
1. Download randomized GMER executable from gmer.net.
2. Run as Administrator.
3. Click "Scan" at lower-right corner.
4. Red highlighted items indicate hidden rootkits/hooks.
5. Right-click red items -> Delete (or Disable service & reboot).

Quick Summary for rkhunter (Linux):
1. sudo apt install rkhunter
2. sudo rkhunter --update
3. sudo rkhunter --propupd
4. sudo rkhunter -c --sk
5. View log: /var/log/rkhunter.log