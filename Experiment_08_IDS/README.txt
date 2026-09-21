Experiment 08: Demonstration of Intrusion Detection System (Snort)

For full step-by-step execution instructions and commands, please refer to README.md in this directory.

Quick Command Summary:
1. List Interfaces: snort -W
2. Sniffer Mode: snort -dev -i <interface_no>
3. IDS Mode: snort -c c:\snort\etc\snort.conf -l c:\snort\log -i <interface_no>
4. IDS Console Mode: snort -A console -i <interface_no> -c c:\Snort\etc\snort.conf -l c:\Snort\log -K ascii